<?php
include 'conexion.php';
//$titulo = $_REQUEST['titulo'];
//$fecha = $_REQUEST['fecha'];
$funcionarios = $_REQUEST['funcionarios'];
$idProceso = $_REQUEST['id'];

//conecer cuantos detalles tiene un proceso
if(isset($funcionarios) && isset($idProceso)){
    $delete = "delete from procesosdetail
            where id_pro_per = $idProceso";
    $result = mysqli_query($conn, $delete);

    for($i = 0; $i < sizeof($funcionarios) ; $i++){
        $sqlUpdate = "INSERT INTO procesosdetail (ID_FUN_PER, ID_PRO_PER, OBS_REV, EST_PRO)  VALUES ('$funcionarios[$i]',$idProceso,'NULL','REVISAR')";
        $result = mysqli_query($conn, $sqlUpdate);          
    }

    echo json_encode("Actualizado correctamente");
}else{
    echo json_encode("Asignar valores");
}

/*


$sqlSelect = "SELECT COUNT(*) 
              FROM procesosdetail
              WHERE ID_PRO_PER = '$idProceso'";
$resultado = mysqli_query($conn, $sqlSelect);
if (mysqli_num_rows($resultado) > 0) {
	while($rowData = mysqli_fetch_array($resultado)){
  		$numDetalles = $rowData["0"];
	}
}

//quita funcionarios de un proceso
if(sizeof($funcionarios) < $numDetalles){
    for($i = 0; $i < sizeof($funcionarios) ;$i++){
        $sqlUpdate = "delete from procesosdetail
                where id_pro_per = $idProceso
                and id_fun_per = '$funcionarios[$i]'";
        $result = mysqli_query($conn, $sqlUpdate);          
    }
}

//adiciona funcionarios al proceso
if(sizeof($funcionarios) > $numDetalles){
    for($i = 0; $i < sizeof($funcionarios) ;$i++){
        $sqlUpdate = "INSERT INTO procesosdetail (ID_FUN_PER, ID_PRO_PER, OBS_REV, EST_PRO)  VALUES ('$funcionarios[$i]',$idProceso,'NULL','REVISAR')";
        $result = mysqli_query($conn, $sqlUpdate);          
    }
}
*/
?>