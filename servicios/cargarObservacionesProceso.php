<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept, Authorization');
header('Content-Type: application/json');
header('Access-Control-Allow-Methods: POST, GET, OPTIONS');
include 'conexion.php';

$idProceso = $_REQUEST['idProceso'];

$sqlSelect = "SELECT OBS_REV FROM procesosdetail where ID_PRO_DET = '$idProceso'";

//Ejecuta el query

$result = mysqli_query($conn, $sqlSelect);

if ($observacion = $result->fetch_assoc()){
    echo json_encode($observacion, JSON_FORCE_OBJECT);
}else{
    $result = "No hay activos";
}

?>