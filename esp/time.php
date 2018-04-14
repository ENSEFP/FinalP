<?php 
require "conn.php";

$begin_time = $_GET["begin_time"];
$end_time = $_GET["end_time"];

$sql = "UPDATE configuration SET begin_time='$begin_time', end_time='$end_time' WHERE id=0";

if ($conn->query($sql) === TRUE) {
    
} else {
    echo "Error updating record: " . $conn->error;
}

session_start();

$begin_time_change = false;
$end_time_change = false;

$sql = "SELECT id, begin_time, end_time FROM configuration";
$result = $conn->query($sql);


if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $begin_time = $row["begin_time"];
        $end_time = $row["end_time"];
        
    }
}
else{
    echo "0 results";
}

if ($begin_time != $_COOKIE["begin_time"]){
    $begin_time_change= true;
}
if ($end_time != $_COOKIE["end_time"]){
    $end_time_change= true;
}

setcookie("begin_time_change", $begin_time_change, time() + (86400 * 30), "/");
setcookie("begin_time", $begin_time, time() + (86400 * 30), "/");

setcookie("end_time_change", $end_time_change, time() + (86400 * 30), "/");
setcookie("end_time", $end_time, time() + (86400 * 30), "/");
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
        <th>Currently New Time of Notification has changed</th>
        <tr>
            <td id="a" class="begin_time">Begin Time is: <u><?php echo $begin_time; ?>:00</u></td>
            
        </tr>
        <tr>
            <td id="b" class="end_time">End_time is: <u><?php echo $end_time; ?>:00</u></td>
        </tr>
    </table>
        
        
	</body>
</html>