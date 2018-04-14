<?php

include("connection.php");
session_start();

$bedroom_led;
$living_room_led;
$kitchen_led;
$fan;
$furnace;
$door;
$buzzer;
$temperature_heat;
$temperature_cool;

$bedroom_led_change = false;
$living_room_led_change = false;
$kitchen_led_change = false;
$fan_change = false;
$furnace_change = false;
$door_change = false;
$buzzer_change = false;
$temperature_heat_change =false;
$temperature_cool_change =false;

$sql = "SELECT `id`, `bedroom_led`, `living_room_led`, `kitchen_led`, `fan`, `furnace`, `door`, `buzzer` FROM `smarthome_basic`";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $bedroom_led = $row["bedroom_led"];
        $living_room_led = $row["living_room_led"];
        $kitchen_led = $row["kitchen_led"];
        $fan = $row["fan"];
        $furnace = $row["furnace"];
        $door = $row["door"];
        $buzzer = $row["buzzer"];
    }
}
else{
    echo "0 results";
}

$sql = "SELECT `id`, `temperature_heat`, `temperature_cool` FROM `configuration`";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $temperature_heat = $row["temperature_heat"];
        $temperature_cool = $row["temperature_cool"];
    }
}
else{
    echo "0 results";
}

if ($bedroom_led != $_COOKIE["bedroom_led"]){
    $bedroom_led_change = true;
}
if ($living_room_led != $_COOKIE["living_room_led"]){
    $living_room_led_change = true;
}
if ($kitchen_led != $_COOKIE["kitchen_led"]){
    $kitchen_led_change = true;
}
if ($fan != $_COOKIE["fan"]){
    $fan_change = true;
}
if ($furnace != $_COOKIE["furnace"]){
    $furnace_change = true;
}
if ($door != $_COOKIE["door"]){
    $door_change = true;
}
if ($buzzer != $_COOKIE["buzzer"]){
    $buzzer_change = true;
}
if ($temperature_heat != $_COOKIE["temperature_heat"]){
    $temperature_heat_change = true;
}
if ($temperature_cool != $_COOKIE["temperature_cool"]){
    $temperature_cool_change = true;
}


setcookie("bedroom_led_change", $bedroom_led_change, time() + (86400 * 30), "/");
setcookie("living_room_led_change", $living_room_led_change, time() + (86400 * 30), "/");
setcookie("kitchen_led_change", $kitchen_led_change, time() + (86400 * 30), "/");
setcookie("fan_change", $fan_change, time() + (86400 * 30), "/");
setcookie("furnace_change", $furnace_change, time() + (86400 * 30), "/");
setcookie("door_change", $door_change, time() + (86400 * 30), "/");
setcookie("buzzer_change", $buzzer_change, time() + (86400 * 30), "/");
setcookie("temperature_heat_change", $temperature_heat_change, time() + (86400 * 30), "/");
setcookie("temperature_cool_change", $temperature_cool_change, time() + (86400 * 30), "/");


setcookie("bedroom_led", $bedroom_led, time() + (86400 * 30), "/");
setcookie("living_room_led", $living_room_led, time() + (86400 * 30), "/");
setcookie("kitchen_led", $kitchen_led, time() + (86400 * 30), "/");
setcookie("fan", $fan, time() + (86400 * 30), "/");
setcookie("furnace", $furnace, time() + (86400 * 30), "/");
setcookie("door", $door, time() + (86400 * 30), "/");
setcookie("buzzer", $buzzer, time() + (86400 * 30), "/");
setcookie("temperature_heat", $temperature_heat, time() + (86400 * 30), "/");
setcookie("temperature_cool", $temperature_cool, time() + (86400 * 30), "/");

?>

<html>
	<head>
		<title>ESP8266 Smart Home Control</title>
        <meta http-equiv="refresh" content="0.1" >
	</head>
	<body>
	
	<!-- in the <button> tags below the ID attribute is the value sent to the arduino -->
	
    <table>
        <tr>
            <td id="2" class="bedroom_led"><?php echo $_COOKIE["bedroom_led"]; ?></td>
            <td id="3" class="living_room_led"><?php echo $_COOKIE["living_room_led"]; ?></td>
            <td id="4" class="kitchen_led"><?php echo $_COOKIE["kitchen_led"]; ?></td>
            <td id="5" class="fan"><?php echo $_COOKIE["fan"]; ?></td>
            <td id="6" class="furnace"><?php echo $_COOKIE["furnace"]; ?></td>
            <td id="9" class="door"><?php echo $_COOKIE["door"]; ?></td>
            <td id="10" class="buzzer"><?php echo $_COOKIE["buzzer"]; ?></td>
            <td id="0" class="temperature_heat"><?php echo $_COOKIE["temperature_heat"]; ?></td>
            <td id="1" class="temperature_cool"><?php echo $_COOKIE["temperature_cool"]; ?></td>
        </tr>
    </table>
		
	<script src="jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
            if ("<?php echo $bedroom_led_change; ?>" !=""){
                var p = 2; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $bedroom_led ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $living_room_led_change; ?>" !=""){
                var p = 3; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $living_room_led ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $kitchen_led_change; ?>" !=""){
                var p = 4; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $kitchen_led ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $fan_change; ?>" !=""){
                var p = 5; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $fan ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $furnace_change; ?>" !=""){
                var p = 6; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $furnace ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $door_change; ?>" !=""){
                var p = 9; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $door ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $buzzer_change; ?>" !=""){
                var p = 10; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $buzzer ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $temperature_heat_change; ?>" !=""){
                var p = 0; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $temperature_heat ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $temperature_cool_change; ?>" !=""){
                var p = 1; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $temperature_cool ?>";
				$.get("http://192.168.4.1/esp/smarthome_basic.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
		});
	</script>
        
        
	</body>
</html>