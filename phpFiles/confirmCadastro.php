<?php
    include 'conexao.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        $nomeUser = $_POST['nomeUser'];
        $emailUser = $_POST['emailUser'];
        $matriculaUser = $_POST['matriculaUser'];
        $telefoneUser = $_POST['telefoneUser'];
        $cidadeUser = $_POST['cidadeUser'];
        $senhaUser = $_POST['senhaUser'];
		//arrumar um jeito de desincriptografar pra comparar no login:
		//$senhaUser = password_hash($senhaUser, PASSWORD_DEFAULT);
		
		//TODO: VERIFICAR SE JA TEM MESMO EMAIL/CELULAR CADASTRADO
        $sql = "INSERT INTO 'tblusers'('nomeUser', 'emailUser', 'matriculaUser', 'telefoneUser', 'cidadeUser', 'senhaUser')
		VALUES ('".$nomeUser."', '".$emailUser."', '".$matriculaUser."', '".$telefoneUser."', '".$cidadeUser."', '".$senhaUser."')";
        if(mysqli_query($conexao, $sql)){
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