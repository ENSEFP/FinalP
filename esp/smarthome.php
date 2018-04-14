<?php

include("connection.php");
session_start();

$led;
$door;
$motor;
$buzzer;

$led_change = false;
$door_change = false;
$motor_change = false;
$buzzer_change = false;


$sql = "SELECT led, door, motor, buzzer FROM smarthome";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $led = $row["led"];
        $door = $row["door"];
        $motor = $row["motor"];
        $buzzer = $row["buzzer"];
    }
    
} else {
    echo "0 results";
}

if ($led != $_COOKIE["led"]){
    $led_change = true;
}
if ($door != $_COOKIE["door"]){
    $door_change = true;
}
if ($motor != $_COOKIE["motor"]){
    $motor_change = true;
}
if ($buzzer != $_COOKIE["buzzer"]){
    $buzzer_change = true;
}
setcookie("led_change", $led_change, time() + (86400 * 30), "/");
setcookie("door_change", $door_change, time() + (86400 * 30), "/");
setcookie("motor_change", $motor_change, time() + (86400 * 30), "/");
setcookie("buzzer_change", $buzzer_change, time() + (86400 * 30), "/");

setcookie("led", $led, time() + (86400 * 30), "/");
setcookie("door", $door, time() + (86400 * 30), "/");
setcookie("motor", $motor, time() + (86400 * 30), "/");
setcookie("buzzer", $buzzer, time() + (86400 * 30), "/");

?>

<html>
	<head>
		<title>ESP8266 LED Control</title>
        <meta http-equiv="refresh" content="5" >
	</head>
	<body>
	
	<!-- in the <button> tags below the ID attribute is the value sent to the arduino -->
	
    <table>
        <tr>
            <td id="2" class="led"><?php echo $_COOKIE["led"]; ?></td>
            <td id="9" class="door"><?php echo $_COOKIE["door"]; ?></td>
            <td id="11" class="motor"><?php echo $_COOKIE["motor"]; ?></td>
            <td id="12" class="buzzer"><?php echo $_COOKIE["buzzer"]; ?></td>
        </tr>
    </table>
      <p>  <?php echo $_COOKIE["led"];?></p>
        <p>  <?php echo $_COOKIE["door"];?></p>
        <p>  <?php echo $_COOKIE["motor"];?></p>
        <p>  <?php echo $_COOKIE["buzzer"];?></p>
      <p id ="alert"></p>
		
	<script src="jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
//			$(".led").bind("DOMNodeInserted", function(){
//				var p = $(this).attr('id'); // get id value (i.e. pin13, pin12, or pin11)
//				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
//				$.get("http://192.168.4.1:80/", {pin:p}); // execute get request
//			});
            if ("<?php echo $led_change; ?>" !=""){
                var p = 2; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                //var action = "<?php echo $_COOKIE["led"] ?>";
                var action = "<?php echo $led ?>";
				$.get("http://192.168.4.1/esp/smarthome.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $door_change; ?>" !=""){
                var p = 9; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                //var action = "<?php echo $_COOKIE["door"] ?>";
                var action = "<?php echo $door ?>";
				$.get("http://192.168.4.1/esp/smarthome.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $motor_change; ?>" !=""){
                var p = 11; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                //var action = "<?php echo $_COOKIE["motor"] ?>";
                var action = "<?php echo $motor ?>";
				$.get("http://192.168.4.1/esp/smarthome.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
            if ("<?php echo $buzzer_change; ?>" !=""){
                var p = 12; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                //var action = "<?php echo $_COOKIE["buzzer"] ?>";
                var action = "<?php echo $buzzer ?>";
				$.get("http://192.168.4.1/esp/smarthome.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
		});
	</script>
        
        
<!--
	<script src="jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
            if (<? php echo $led_change;?>){
                $.get("http://192.168.4.1:80/", {pin:p, action:<?php echo $_COOKIE["led"];?>}); // execute get request
                document.getElementById("alert").innerHTML = "led is working";
            }
                                             
//            $(".led").bind("DOMNodeInserted", function(){
//                $.get("http://192.168.4.1:80/", {pin:p, action:<?php echo $_COOKIE["$led"];?>}); // execute get request
//                
//
//            });
//			$(".led").click(function(){
//				var p = $(this).attr('id'); // get id value (i.e. pin13, pin12, or pin11)
//				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
//				$.get("http://192.168.4.1:80/", {pin:p}); // execute get request
//			});
		});
	</script>
-->
	</body>
</html>
