<?php 
require "conn.php";

$buzzer = $_GET["buzzer"];

$sql = "UPDATE smarthome_basic SET buzzer='$buzzer' WHERE id=0";

if ($conn->query($sql) === TRUE) {
    //echo "Record updated successfully on temperature_heat";
} else {
    echo "Error updating record: " . $conn->error;
}

 
$buzzer_change = false;


$sql = "SELECT `id`, `bedroom_led`, `living_room_led`, `kitchen_led`, `fan`, `furnace`, `door`, `buzzer` FROM `smarthome_basic`";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        $buzzer = $row["buzzer"];
    }
}
else{
    echo "0 results";
}

if ($buzzer != $_COOKIE["buzzer"]){
    $buzzer_change = true;
}

setcookie("buzzer_change", $buzzer_change, time() + (86400 * 30), "/");
setcookie("buzzer", $buzzer, time() + (86400 * 30), "/");


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
        <th>Currently the buzzer is: </th>
        <tr>
            <td id="10" class="buzzer"> 
                <?php 
                    if ($buzzer == 1){
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
            if ("<?php echo $buzzer_change; ?>" !=""){
                var p = 10; // get id value 
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                var action = "<?php echo $buzzer ?>";
				$.get("http://192.168.4.1/esp/buzzer.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
		});
	</script>
        
        
	</body>
</html>