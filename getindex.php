<?php
header('Content-type:application/json');
$con=mysql_connect("localhost","root","")or die('connection error');
mysql_select_db("rhok") or die('selection error ');
//$username=isset($_GET['user'])? mysql_real_escape_string($_GET['user']) : "";// mysql_real_escape_string prevents sql injections !!
//$sql="select product_id from localkiranastore_quicklist where username='$username'";


$sql="SELECT rindex, hindex, eindex from bangalore where Sector='$sector'";
$lol=mysql_query($sql,$con);
$r=mysql_fetch_array($lol,MYSQL_ASSOC);

$result=array("rindex"=>$r['rindex'],"hindex"=>$r['hindex'],"eindex"=>$r['eindex']);
echo json_encode($result);
?>
