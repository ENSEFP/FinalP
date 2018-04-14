<?php 
require "conn.php";

$account = $_REQUEST["account"];
$password = $_REQUEST["password"];


$sql = "SELECT `id`, `account`, `password` FROM `account` WHERE `account`='$account' AND `password`='$password'";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // there is a matched email and password exist in db
    echo "1";
}
else{
    echo "0";
}

?>