<?php
include 'conexion.php';
$titulo = $_REQUEST['titulo'];
$fecha = $_REQUEST['fecha'];
$funcionarios = $_REQUEST['funcionarios'];

$queryProceso = "SELECT (COUNT(*)) FROM procesosheader";
$resultado = mysqli_query($conn, $queryProceso);
if (mysqli_num_rows($resultado) > 0) {
	while($rowData = mysqli_fetch_array($resultado)){
  		$id = $rowData["0"];
	}
}

if(isset($titulo) && isset($funcionarios) && isset($fecha)){
    $query1 = "INSERT INTO procesosheader (ID_PRO, TIT_PRO, FEC_PRO)  VALUES (($id + 1), '$titulo', '$fecha')";
    $resultado1 = mysqli_query($conn, $query1);
    for($i = 0; $i < sizeof($funcionarios) ;$i++){
        $query2 = "INSERT INTO procesosdetail (ID_FUN_PER, ID_PRO_PER, OBS_REV, EST_PRO)  VALUES ('$funcionarios[$i]',($id + 1),'NULL','REVISAR')";
        $resultado2 = mysqli_query($conn, $query2);
    } 
        echo json_encode("El proceso se creo correctamente");
}else{
    echo json_encode('Asignar los valores correspondientes');
}

?>