<?php
include "conexion.inc.php";
$codFlujo=$_GET["codflujo"];
$codProceso=$_GET["codproceso"];
$codProcesoSiguiente=$_GET["codprocesosiguiente"];
$archivo=$_GET["archivo"];
$tipo=$_GET["tipo"];
include "controlador".$archivo;
if ($tipo=='C')
{
	echo $codProceso;
	$sql="select * from proceso ";
	$sql.="where codFlujo='$codFlujo' ";
	$sql.="and codProceso='$codProceso'";
	$result=mysqli_query($conn, $sql);
	$fila=mysqli_fetch_array($result);
	$codprocesoEnvia=$fila['codProceso'];
	$archivoEnvia="motor.php?codflujo=".$codFlujo."&codproceso=".$codprocesoEnvia;
	header("Location: ".$archivoEnvia);
}
else 
{
	if (isset($_GET["Anterior"])) {
		$sql="select * from proceso ";
		$sql.="where codFlujo='$codFlujo' ";
		$sql.="and codProcesoSiguiente='$codProceso'";
	}
	if (isset($_GET["Siguiente"])) {
		$sql="select * from proceso ";
		$sql.="where codFlujo='$codFlujo' ";
		$sql.="and codProceso='$codProcesoSiguiente'";
	}
	$result=mysqli_query($conn, $sql);
	$fila=mysqli_fetch_array($result);
	$codprocesoEnvia=$fila['codProceso'];
	$archivoEnvia="motor.php?codflujo=".$codFlujo."&codproceso=".$codprocesoEnvia;
	header("Location: ".$archivoEnvia);
}

?>
