<?php
include 'conexion.php';
$observacion = $_REQUEST['obs'];
$estadoProceso = $_REQUEST['estadoProceso'];
$idProcesoDet = $_REQUEST['idProcesoDet'];

if(isset($idProcesoDet) ){

    $updateDetail = "update procesosdetail
                     set EST_PRO = '$estadoProceso',
                         OBS_REV =   '$observacion'
                     where ID_PRO_DET = $idProcesoDet";
    $result = mysqli_query($conn, $updateDetail);

    echo json_encode("Actualizado correctamente");
}else{
    echo json_encode("Asignar valores");
}