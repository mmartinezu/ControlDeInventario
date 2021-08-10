<?php
include 'conexion.php';
$observacion = $_REQUEST['obs'];
$estadoActivo = $_REQUEST['estActivo'];
$activosFun = $_REQUEST['activosFun'];
$estadoProceso = $_REQUEST['estadoProceso'];
$idProcesoDet = $_REQUEST['idProcesoDet'];

if(isset($estadoProceso) && isset($estadoActivo) && isset($activosFun) && isset($idProcesoDet) ){

    $updateDetail = "update procesosdetail
                     set EST_PRO = '$estadoProceso',
                         OBS_REV =   '$observacion'
                     where ID_PRO_DET = $idProcesoDet";
    $result = mysqli_query($conn, $updateDetail);

    for($i = 0; $i < sizeof($activosFun) ; $i++){
        $updateActivo = "update activos
                         set REV_ACT = '$estadoActivo[$i]'
                         where ID_ACT = '$activosFun[$i]'";
        $result1 = mysqli_query($conn, $updateActivo);
    }
    echo json_encode("Actualizado correctamente");
}else{
    echo json_encode("Asignar valores");
}