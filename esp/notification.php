<?php
require "conn.php";

//$begin_time = $_GET["begin_time"];
//$end_time = $_GET["end_time"];
//$door = $_GET["door"];


$username = null;
$password = null;
$username = $_REQUEST["user_name"];
$password = $_REQUEST["password"];

$begin_time = -1;
$end_time = -1;
$door = -1;

$sql = "SELECT `begin_time`, `end_time` FROM `configuration`";
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


// get door status
$sql = "SELECT `id`, `bedroom_led`, `living_room_led`, `kitchen_led`, `fan`, `furnace`, `door`, `buzzer` FROM `smarthome_basic`";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        $door = $row["door"];
    }
}
else{
    echo "0 results";
}


date_default_timezone_set('America/Regina');

$script_tz = date_default_timezone_get();



if ($begin_time >= $end_time){  // next day
   if ((date("G") >= $begin_time) || (date("G") <= $end_time)){
        if($door == "1"){
            echo "1";
        }
        else if($door == "0"){
            echo "0";
        }
    }
    else {
        echo "0";
    } 
}
else if ($begin_time < $end_time){  // same day
    if ((date("G") >= $begin_time) && (date("G") <= $end_time)){
        if($door == "1"){
            echo "1";
        }
        else {
            echo "0";
        }
    }
    else {
        echo "0";
    }
}


?>
