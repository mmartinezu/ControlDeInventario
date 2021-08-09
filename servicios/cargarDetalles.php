<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept, Authorization');
header('Content-Type: application/json');
header('Access-Control-Allow-Methods: POST, GET, OPTIONS');
include 'conexion.php';

$titulo = $_REQUEST['titulo'];

$sqlSelect = "SELECT ID_PRO_DET, ID_FUN_PER, ID_PRO_PER, OBS_REV, EST_PRO, f.ID_FUN, f.NOM_FUN, f.APE_FUN, f.NUM_ACT_FUN 
                FROM procesosdetail as pd, procesosheader as ph, funcionarios as f
                where pd.ID_PRO_PER = ph.ID_PRO
                and f.ID_FUN = pd.ID_FUN_PER
                and ph.TIT_PRO = '$titulo'";
//Ejecuta el query
$respuesta = $conn->query($sqlSelect);
$result = array();
if ($respuesta->num_rows > 0){
    //Recorre cada fila
    while ($filaActivo = $respuesta->fetch_assoc()){
        //Guarda cada fila en una posicion del array
        array_push($result, $filaActivo);
    }
}else{
    $result = "No hay detalle del proceso";
}
echo json_encode($result, JSON_FORCE_OBJECT);
?>
