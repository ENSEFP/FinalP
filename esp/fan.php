<?php 
require "conn.php";

$fan = $_GET["fan"];

$sql = "UPDATE smarthome_basic SET fan='$fan' WHERE id=0";

if ($conn->query($sql) === TRUE) {
    //echo "Record updated successfully on temperature_heat";
} else {
    echo "Error updating record: " . $conn->error;
}

$fan_change = false;
 
$sql = "SELECT `id`, `bedroom_led`, `living_room_led`, `kitchen_led`, `fan`, `furnace`, `door`, `buzzer` FROM `smarthome_basic`";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $fan = $row["fan"];
    }
}
else{
    echo "0 results";
}

if ($fan != $_COOKIE["fan"]){
    $fan_change = true;
}

setcookie("fan_change", $fan_change, time() + (86400 * 30), "/");
setcookie("fan", $fan, time() + (86400 * 30), "/");


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
        <th>Currently the fan is in level: </th>
        <tr>
            <td id="5" class="fan"><?php echo $fan; ?></td>
            
        </tr>
    </table>
		
	<script src="jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
            if ("<?php echo $fan_change; ?>" !=""){
                var p = 5; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $fan ?>";
				$.get("http://192.168.4.1/esp/fan.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
		});
	</script>
        
        
	</body>
</html>