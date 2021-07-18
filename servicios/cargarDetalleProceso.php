<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept, Authorization');
header('Content-Type: application/json');
header('Access-Control-Allow-Methods: POST, GET, OPTIONS');
include 'conexion.php';

$titulo = $_REQUEST['titulo'];
$sqlSelect = "SELECT pd.ID_PRO_DET, f.NOM_FUN, f.APE_FUN, f.NUM_ACT_FUN ,pd.EST_PRO 
              FROM procesosdetail as pd, funcionarios as f, procesosheader as ph
              where TIT_PRO = '$titulo'
              and f.ID_FUN = pd.ID_FUN_PER
              and ph.ID_PRO = pd.ID_PRO_PER";
//Ejecuta el query
$respuesta = $conn->query($sqlSelect);
$result = array();
if ($respuesta->num_rows > 0){
    //Recorre cada fila
    while ($filaFuncionario = $respuesta->fetch_assoc()){
        //Guarda cada fila en una posicion del array
        array_push($result, $filaFuncionario);
    }
}else{
    $result = "No hay procesos";
}
echo json_encode($result, JSON_FORCE_OBJECT);
?>