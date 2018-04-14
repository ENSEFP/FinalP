<?php 
require "conn.php";

$temperature_too_high = $_GET["temperature_too_high"];

$sql = "UPDATE configuration SET temperature_too_high='$temperature_too_high' WHERE id=0";

if ($conn->query($sql) === TRUE) {
    //echo "Record updated successfully on temperature_heat";
} else {
    echo "Error updating record: " . $conn->error;
}

session_start();

$temperature_too_high_change = false;

$sql = "SELECT id, temperature_too_high, temperature_too_low FROM configuration";
$result = $conn->query($sql);


if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $temperature_too_high = $row["temperature_too_high"];
        
    }
}
else{
    echo "0 results";
}

if ($temperature_too_high != $_COOKIE["temperature_too_high"]){
    $temperature_too_high_change= true;
}

setcookie("temperature_too_high_change", $temperature_too_high_change, time() + (86400 * 30), "/");
setcookie("temperature_too_high", $temperature_too_high, time() + (86400 * 30), "/");

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
        <th>Currently Alarm will be triggerred if temperature is higher than:</th>
        <tr>
            <td id="7" class="temperature_too_high"><?php echo $temperature_too_high; ?> Degrees</td>
            
        </tr>
    </table>
		
	<script src="jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
            if ("<?php echo $temperature_too_high_change; ?>" !=""){
                var p = 7; // get id value 
                var temp = "<?php echo $temperature_too_high; ?>";
                if (temp ==16 || temp == 17){
                    action = 1;
                }
                else if (temp ==18 || temp == 19){
                    action = 2;
                }
                else if (temp ==20 || temp == 21){
                    action = 3;
                }
                else if (temp ==22 || temp == 23){
                    action = 4;
                }
                else if (temp ==24 || temp == 25){
                    action = 5;
                }
                else if (temp ==26 || temp == 27){
                    action = 6;
                }
                else if (temp ==28 || temp == 29){
                    action = 7;
                }
                else if (temp ==30 || temp == 31){
                    action = 8;
                }
                else if (temp ==32 || temp == 33){
                    action = 9;
                }
                else {
                    action = 0;
                }
				// send HTTP GET request to the IP address with the parameter "pin" and value "p", then execute the function
                //var action = "<?php echo $temperature_too_high ?>";
				$.get("http://192.168.4.1/esp/temperature_too_high.php/?pin=" + p + "&action=" + action); // execute get request
                
            }
		});
	</script>
        
        
	</body>
</html>