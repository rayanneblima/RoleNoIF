<?php
    include 'conexao.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        $nomeUser = $_POST['nomeUser'];
        $emailUser = $_POST['emailUser'];
        $matriculaUser = $_POST['matriculaUser'];
        $telefoneUser = $_POST['telefoneUser'];
        $cidadeUser = $_POST['cidadeUser'];
        $senhaUser = password_hash($_POST['senhaUser'], PASSWORD_DEFAULT);

		//Verifica se já possui o mesmo e-mail cadastrado
		$verificar = mysqli_query($conexao, "SELECT * FROM tblusers WHERE emailUser = '".$emailUser."' ") or print mysql_error();
        $possuicad = mysqli_num_rows($verificar);
        if($possuicad != 0){
            $result["code"] = "cadastrado";
            echo json_encode($result);
            mysqli_close($conexao);
        } else {
      		//Cadastrar e enviar json de mensagem de sucesso ou erro
            $cadastrar = "INSERT INTO tblusers(nomeUser, emailUser, matriculaUser, telefoneUser, cidadeUser, senhaUser)
    	VALUES ('".$nomeUser."', '".$emailUser."', '".$matriculaUser."', '".$telefoneUser."', '".$cidadeUser."', '".$senhaUser."')";
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
    }
?>
