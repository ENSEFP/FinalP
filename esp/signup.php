<?php 
require "conn.php";

$account = $_REQUEST["account"];
$password = $_REQUEST["password"];


$sql = "INSERT INTO `account`(`account`, `password`) VALUES ('$account', '$password')";

$result = $conn->query($sql);

if ($result) {
    // there is a matched email and password exist in db
    echo "1";
}
else{
    echo "0";
}

?>