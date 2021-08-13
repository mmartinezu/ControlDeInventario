<?php
include 'conexion.php';
//$revisionActivo = $_REQUEST['revisionActivo'];
$idActivo = $_REQUEST['idActivo'];

if(isset($idActivo)){
    $updateRevisionActivo = "update activos
                     set REV_ACT = 'N'
                     where ID_ACT= '$idActivo'";
    $result = mysqli_query($conn, $updateRevisionActivo);

    echo json_encode("Revisado correctamente");
}else{
    echo json_encode("Asignar valores");
}