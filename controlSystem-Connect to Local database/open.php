<?php 
require "conn.php";
$pin13 = $_REQUEST["pin13"];

$sql = "UPDATE test SET pin13='$pin13' WHERE id=1";

if ($conn->query($sql) === TRUE) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn->error;
}

 
?>