<?php
//ALTER TABLE table AUTO_INCREMENT = 1

//require('ErrorReport.php');
//$servername = "biz169";
//$username = "skfurn5_crm";
//$password = "Honest801";
//$dbName = "skfurn5_super_admin";
$servername = "localhost";
$username = "root";
$password = "";
$dbName = "webappdb";

$con = mysqli_connect($servername, $username, $password, $dbName);

if (mysqli_connect_errno())
  {
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }else{
    echo "Connection successful";
}

//$con1 = mysqli_select_db($con, 'CRManagement');


//echo "Connected successfully";



?>