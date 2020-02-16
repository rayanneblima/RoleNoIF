<!DOCTYPE html>
<html lang="pt">
<head>
	<title>Cadastro</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

				<form class="login100-form validate-form flex-sb flex-w" method = "post" action = "cadastro.php">
					<span class="login100-form-title p-b-51">
						Cadastro			
					</span>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Nome obrigatório.">
						<input class="input100" type="text" name="nomeUser" placeholder="nome">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Mat obrigatório.">
						<input class="input100" type="number" name="matriculaUser" placeholder="mat">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Tel obrigatório.">
						<input class="input100" type="number" name="telefoneUser" placeholder="tel">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "cidade obrigatório.">
						<input class="input100" type="text" name="cidadeUser" placeholder="cidade">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "E-mail obrigatório.">
						<input class="input100" type="email" name="emailUser" placeholder="e-mail">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Senha obrigatória.">
						<input class="input100" type="password" name="senhaUser" placeholder="senha">
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">
							cadastrar
						</button>
					</div>

				</form>

               
</body>
</html>