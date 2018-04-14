#include <SoftwareSerial.h> 
#include <Servo.h>

#define DEBUG true

int temp = 0;
Servo myservo;
SoftwareSerial esp8266(7, 8); // make RX Arduino line is pin 7, make TX Arduino line is pin 8.
                              // This means that you need to connect the TX line from the esp to the Arduino's pin 7
                              // and the RX line from the esp to the Arduino's pin 8

float cel =-99;

int bedroom_led = 2;
int living_room_led = 3;
int kitchen_led = 4;
int fan = 5;
int furnace = 6;
int door = 9;
int buzzer = 10;
int heat_led = 12;
int cool_led = 13;
int temperature_to_heat_up = 0;
int temperature_to_cool_down = 1;

int pos = 120;
int temperature_analog = 1;

int temperature_too_high_value = -99;
int temperature_too_low_value = -99;
int temperature_to_heat_up_value = -99;
int temperature_to_cool_down_value = -99;

void setup() {
  Serial.begin(9600);
  esp8266.begin(9600);

  pinMode(bedroom_led, OUTPUT);
  pinMode(living_room_led, OUTPUT);
  pinMode(kitchen_led, OUTPUT);
  pinMode(fan, OUTPUT);
  pinMode(furnace, OUTPUT);
  pinMode(door, OUTPUT);
  pinMode(buzzer, OUTPUT);
  pinMode(heat_led, OUTPUT);
  pinMode(cool_led, OUTPUT);

  sendData("AT+RST\r\n", 2000, DEBUG); // reset module
  sendData("AT+CWMODE=3\r\n", 1000, DEBUG); // configure as access point
  sendData("AT+CIPMUX=1\r\n", 1000, DEBUG); // configure for multiple connections

  sendData("AT+CIPSERVER=1,80\r\n", 1000, DEBUG); // turn on server on port 80
  sendData("AT+CIFSR\r\n", 1000, DEBUG); // get ip address

}

void loop() {
  if (esp8266.available()) // check if the esp is sending a message 
  {

    if (esp8266.find("+IPD,")) {
      delay(1000); // wait for the serial buffer to fill up (read all the serial data)
      // get the connection id so that we can then disconnect
      int connectionId = esp8266.read() - 48; // subtract 48 because the read() function returns 
      // the ASCII decimal value and 0 (the first decimal number) starts at 48

      esp8266.find("pin="); // advance cursor to "pin="
      int pinNumber = (esp8266.read() - 48); // get first number i.e. if the pin 13 then the 1st number is 1, then multiply to get 10

      esp8266.find("action="); // advance cursor to "action="
      int actionNumber = (esp8266.read() - 48); // find the action (1 or 0)

//      int actionNumber2 = -1;
//      esp8266.find("action2=");
//      if (esp8266.find("action2=")){
//        actionNumber2 = (esp8266.read() - 48);
//      }
      if (pinNumber == bedroom_led || pinNumber == living_room_led || pinNumber == kitchen_led) {
        if (actionNumber == 1) {
          digitalWrite(pinNumber, HIGH);

          Serial.println("I open it " + actionNumber);
          delay(1000);
        } else if (actionNumber == 0) {
          digitalWrite(pinNumber, LOW);

          Serial.println("I close it " + actionNumber);
          delay(1000);
        }
      } 
      
      else if (pinNumber == door) {
        myservo.attach(9); // servo
        if (actionNumber == 1) {
          for (pos = 0; pos <= 120; pos += 1) { // goes from 0 degrees to 180 degrees
            // in steps of 1 degree
            myservo.write(pos); // tell servo to go to position in variable 'pos'
            delay(10); // waits 15ms for the servo to reach the position

          }
        } else if (actionNumber == 0) {
          for (pos = 120; pos >= 0; pos -= 1) { // goes from 180 degrees to 0 degrees
            myservo.write(pos); // tell servo to go to position in variable 'pos'
            delay(10); // waits 15ms for the servo to reach the position

          }
        }
        myservo.detach();
      } 
      
      else if (pinNumber == fan) {
        if (actionNumber == 0) {
          analogWrite(fan, 0);
        } else if (actionNumber == 1) {
          analogWrite(fan, 64);
          Serial.println("YES");
        } else if (actionNumber == 2) {
          analogWrite(fan, 127);
          Serial.println("YES");
        } else if (actionNumber == 3) {
          analogWrite(fan, 255);
        }
      }

      else if (pinNumber == 0) {
        temperature_to_heat_up_value = convertor(actionNumber);
        //temperature_to_cool_down_value = convertor(actionNumber2);
      }

      else if (pinNumber ==7){
        temperature_too_high_value = convertor(actionNumber);
      }
      else if (pinNumber ==8){
        temperature_too_low_value =convertor(actionNumber);
      }

      
      // make close command
      String closeCommand = "AT+CIPCLOSE=";
      closeCommand += connectionId; // append connection id
      closeCommand += "\r\n";

      sendData(closeCommand, 1000, DEBUG); // close connection
    }
  }

  // receive analog temperature
  
//  if (temp == 0){
    int temperature = analogRead(temperature_analog);
    float mv = (temperature / 1024.0) * 5000;
    float cel = mv / 10;
//    temp = 5000;
//  }
//  temp--;
  // temp is counting the times of loop 
  // when reaches to 50 output once the current temperature
  //if (temp ==1500){
  Serial.print("CURRENT TEMPRATURE = ");
  Serial.print(cel);
  Serial.print("*C");
  Serial.print(temperature_to_heat_up_value);
  Serial.print(" ");
  Serial.print(temperature_to_cool_down_value);
  Serial.println();

  // trigger the buzzer 
  if ((cel >= temperature_too_high_value && temperature_too_high_value != -99) || (cel <= temperature_too_low_value && temperature_too_low_value != -99)) {

//    digitalWrite(2, HIGH);
//    digitalWrite(3, LOW);
//    delay(50);

//    for (int x = 0; x <= 255; x++) {
//      analogWrite(10, x);
//      delay(8);
//    }
//
//    // ramp down the motor speed
//    for (int x = 255; x >= 0; x--) {
//      analogWrite(10, x);
//      delay(8);
//    }

      //analogWrite(10,255);
      tone(buzzer,100);
      delay(50);
  } 
  
  else {
    noTone(buzzer);
    //analogWrite(10, 0);
    delay(1);
  }

  // to activate furnace
  if (cel < temperature_to_heat_up_value && temperature_to_heat_up_value!= -99) {
    digitalWrite(heat_led, HIGH);
    digitalWrite(cool_led, LOW);
    digitalWrite(furnace, HIGH);
  } 
  
  else if (cel > temperature_to_heat_up_value && temperature_to_heat_up_value != -99) {
    digitalWrite(cool_led, HIGH);
    digitalWrite(heat_led, LOW);
    digitalWrite(furnace, HIGH);
  } 
  
  else {
    digitalWrite(cool_led, LOW);
    digitalWrite(heat_led, LOW);
    digitalWrite(furnace, LOW);
  }

}

/*
 * Name: sendData
 * Description: Function used to send data to ESP8266.
 * Params: command - the data/command to send; timeout - the time to wait for a response; debug - print to Serial window?(true = yes, false = no)
 * Returns: The response from the esp8266 (if there is a reponse)
 */
String sendData(String command,
  const int timeout, boolean debug) {
  String response = "";

  esp8266.print(command); // send the read character to the esp8266

  long int time = millis();

  while ((time + timeout) > millis()) {
    while (esp8266.available()) {

      // The esp has data so display its output to the serial window 
      char c = esp8266.read(); // read the next character.
      response += c;
    }
  }

  if (debug) {
    Serial.print(response);
  }

  return response;
}

// temperature convert range is between 16'C to 32'C or -99 
int convertor(int i) {
  switch (i) {
  case 1:
    return 16;
  case 2:
    return 18;
  case 3:
    return 20;
  case 4:
    return 22;
  case 5:
    return 24;
  case 6:
    return 26;
  case 7:
    return 28;
  case 8:
    return 30;
  case 9:
    return 32;
  default:
    return -99;

  }

}
