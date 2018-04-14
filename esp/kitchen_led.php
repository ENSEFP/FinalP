<?php 
require "conn.php";
$kitchen_led = $_GET["kitchen_led"];


$sql = "UPDATE smarthome_basic SET kitchen_led='$kitchen_led' WHERE id=0";

if ($conn->query($sql) === TRUE) {
    //echo "Record updated successfully on temperature_heat";
} else {
    echo "Error updating record: " . $conn->error;
}

$kitchen_led_change = false;
 
$sql = "SELECT `id`, `bedroom_led`, `living_room_led`, `kitchen_led`, `fan`, `furnace`, `door`, `buzzer` FROM `smarthome_basic`";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        $kitchen_led = $row["kitchen_led"];

    }
}
else{
    echo "0 results";
}
    if ($kitchen_led != $_COOKIE["kitchen_led"]){
        $kitchen_led_change = true;
    }


setcookie("kitchen_led_change", $kitchen_led_change, time() + (86400 * 30), "/");
setcookie("kitchen_led", $kitchen_led, time() + (86400 * 30), "/");


?>

<html>
	<head>
		<title>ESP8266 Smart Home Control</title>
        <link rel="stylesheet" href="style.css">
        <!--<meta http-equiv="refresh" content="0.1" > -->
	</head>
	<body>
	
	<!-- in the <button> tags below the ID attribute is the value sent to the arduino -->
	
    <table class="greenTable">
        <th>Currently the kitchen light is: </th>
        <tr>
           <td id="4" class="kitchen_led">
               <?php 
                    if ($kitchen_led == 1){
                        echo "ON";
                    } 
                    else{
                        echo "OFF";
                    }
                ?>
            </td>
            
        </tr>
    </table>
		
	<script src="jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
            if ("<?php echo $kitchen_led_change; ?>" !=""){
                var p = 4; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $kitchen_led ?>";
				$.get("http://192.168.4.1/esp/kitchen_led.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
		});
	</script>
        
        
	</body>
</html>