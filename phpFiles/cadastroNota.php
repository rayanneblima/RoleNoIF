<?php
    include 'conexao.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        $emailUser = $_POST['emailUser'];
        $nomeCurso = $_POST['nomeCurso'];
        $notaCurso = $_POST['notaCurso'];

		$cadastrar = "INSERT INTO tblnotas(emailUser, nomeCurso, notaCurso)
    	VALUES ('".$emailUser."', '".$nomeCurso."', '".$notaCurso."')";
        if(mysqli_query($conexao, $cadastrar)){
            $result["code"] = "sucess";
            echo json_encode($result);
            mysqli_close($conexao);
        }else { 
            $result["code"] = "failed";
            echo json_encode($result);
            mysqli_close($conexao);
        }
    }
?>
