<?php

    require "connection.php";
    
    $name = $_POST["email"];
    //$user_name = $_POST["email"];
    $user_pass = $_POST["password"];
    

    $sql_query = "insert into user_info (name, user_pass) values('$name', '$user_pass')";

    if(mysqli_query($con, $sql_query)){
        echo "<h3>Data insertation success...</h3>"
    }else{
        echo "Data insertion error..".mysqli_error($con);
    }

?>