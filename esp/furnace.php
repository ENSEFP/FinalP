<?php 
require "conn.php";

$furnace = $_GET["furnace"];

$sql = "UPDATE smarthome_basic SET furnace='$furnace' WHERE id=0";

if ($conn->query($sql) === TRUE) {
    //echo "Record updated successfully on temperature_heat";
} else {
    echo "Error updating record: " . $conn->error;
}

$furnace_change = false;

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

if ($furnace != $_COOKIE["furnace"]){
    $furnace_change = true;
}

setcookie("furnace_change", $furnace_change, time() + (86400 * 30), "/");
setcookie("furnace", $furnace, time() + (86400 * 30), "/");


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
        <th>Currently the furnace is:</th>
        <tr>
            <td id="6" class="furnace">
                <?php 
                    if ($furnace == 1){
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
            if ("<?php echo $furnace_change; ?>" !=""){
                var p = 6; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $furnace ?>";
				$.get("http://192.168.4.1/esp/furnace.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
		});
	</script>
        
        
	</body>
</html>