<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbName = "smarthome";

$conn = mysqli_connect($servername, $username, $password, $dbName);

if (mysqli_connect_errno()){

    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
echo "Successfully connect to db";

?>