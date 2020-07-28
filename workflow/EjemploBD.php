<?php
include "conexion.inc.php";
$result=mysqli_query($conn, "select * from proceso where codproceso='P1'");
$fila=mysqli_fetch_array($result);
$proceso=$fila['codFlujo'];
echo $proceso;
?>