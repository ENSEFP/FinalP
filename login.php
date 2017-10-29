<?php


    require "connection.php";
    $user_name = $_POST[""];
    $user_pass = $_POST[""];

    $sql_query = "select name from user_info where user_name like '$user_name' and user_pass like '$user_pass'";

    $result = mysqli_query($con, $sql_query);

    if(mysqli_num_rows($result) > 0){
        $row = mysqli_ferch_assoc($result);
        $name = $row["name"];
        echo "<h3>Hello welcome".$name."</h3>";
    }else{
        echo "No info is available.";
    }
      
?>