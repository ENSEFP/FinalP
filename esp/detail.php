<?php
require "conn.php";

$bedroom_led =-1;
$living_room_led =-1;
$kitchen_led =-1;
$fan =-1;
$furnace =-1;
$door =-1;
$buzzer =-1;

$temperature_heat =-1;
$temperature_cool =-1;
$temperature_too_high =-1;
$temperature_too_low =-1;
$begin_time = -1;
$end_time = -1;


$sql = "SELECT `id`, `temperature_heat`, `temperature_cool`, `temperature_too_high`, `temperature_too_low`, `begin_time`, `end_time` FROM `configuration`";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $temperature_heat = $row["temperature_heat"];
        $temperature_cool = $row["temperature_cool"];
        $temperature_too_high = $row["temperature_too_high"];
        $temperature_too_low = $row["temperature_too_low"];
        $begin_time = $row["begin_time"];
        $end_time = $row["end_time"];
        
    }
}
else{
    echo "0 results";
}


// get door status
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

if ($bedroom_led == "1"){
    $bedroom_led = "ON";
}
else {
    $bedroom_led = "OFF";
}

if ($living_room_led == "1"){
    $living_room_led = "ON";
}
else {
    $living_room_led = "OFF";
}

if ($kitchen_led == "1"){
    $kitchen_led = "ON";
}
else{
    $kitchen_led = "OFF";
}

if ($fan == "1"){
    $fan = "ON";
}
else{
    $fan = "OFF";
}

if ($furnace == "1"){
    $furnace = "ON";
}
else{
    $furnace = "OFF";
}

if ($door == "1"){
    $door = "ON";
}
else {
    $door = "OFF";
}

if ($buzzer == "1"){
    $buzzer = "ON";
}
else {
    $buzzer = "OFF";
}

if ($temperature_heat == "-99"){
    $temperature_heat = "required to set";
}
else {
    $temperature_heat = $temperature_heat;
}

if ($temperature_too_high == "-99"){
    $temperature_too_high = "required to set";
}
else {
    $temperature_too_high = $temperature_too_high;
}

if ($temperature_too_low == "-99"){
    $temperature_too_low = "required to set";
}
else {
    $temperature_too_low = $temperature_too_low ;
}


setcookie("bedroom_led", $bedroom_led, time() + (86400 * 30), "/");
setcookie("living_room_led", $living_room_led, time() + (86400 * 30), "/");
setcookie("kitchen_led", $kitchen_led, time() + (86400 * 30), "/");
setcookie("fan", $fan, time() + (86400 * 30), "/");
setcookie("furnace", $furnace, time() + (86400 * 30), "/");
setcookie("door", $door, time() + (86400 * 30), "/");
setcookie("buzzer", $buzzer, time() + (86400 * 30), "/");

setcookie("temperature_heat", $temperature_heat, time() + (86400 * 30), "/");
setcookie("temperature_cool", $temperature_cool, time() + (86400 * 30), "/");

setcookie("temperature_too_high", $temperature_too_high, time() + (86400 * 30), "/");
setcookie("temperature_too_low", $temperature_too_low, time() + (86400 * 30), "/");

setcookie("begin_time", $begin_time, time() + (86400 * 30), "/");
setcookie("end_time", $end_time, time() + (86400 * 30), "/");
?>

<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<style>
    b {
     color: red;
    }
</style>
</head>
<body>

<p>bedroom led is:<b> <?php echo $bedroom_led; ?></b></p>
<p>living room led is: <b><?php echo $living_room_led; ?></b></p>
<p>kitchen led is: <b><?php echo $kitchen_led; ?></b></p>
<p>fan is: <b><?php echo $fan; ?></b></p>
<p>furnace is: <b><?php echo $furnace; ?></b></p>
<p>door is: <b><?php echo $door; ?></b></p>
<p>buzzer is: <b><?php echo $buzzer; ?></b></p>
<p>temperature required to set on auto mode: <b><?php echo $temperature_heat; ?></b></p>

<p>temperature notification when higher than: <b><?php echo $temperature_too_high; ?></b></p>
<p>temperature notification when lower than: <b><?php echo $temperature_too_low; ?></b></p>
<p>Notify during: <b><?php echo $begin_time; ?>:00 to <?php echo $end_time; ?>:00 <?php if($begin_time >= $end_time){echo "(+1)";} ?></b></p>
</body>
</html>
