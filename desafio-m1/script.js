
//chamada API
async function getData() {
	let url = 'https://igti-film.herokuapp.com/api/accounts';
	let data;

	await fetch(url)
    .then(async response => { 
    	data = await response.json() ;
    })
    .catch(reason => console.log(reason));

    return data;
}

//questão1 - soma dos depósitos
function somaDeposito(arr) {
	let sum = 0;

	for(let i = 0; i < arr.length; i++) {
		sum = sum + arr[i].balance;
	}

	document.getElementById('resposta1').innerHTML = sum;
}

//saldo(data, numero de comparação)
function saldoMaior(arr, limite) {
	let newArr = [];

	newArr = arr.filter(el => el.balance > 100)
	document.getElementById('resposta2').innerHTML = newArr.length;	
}

function saldoMaiorAgencia(arr, limite, ag) {
	let newArr = [];

	newArr = arr.filter(el => el.agencia == ag).filter(el => el.balance > 100)
	document.getElementById('resposta3').innerHTML = newArr.length;	
}

function agMaiorSaldo(arr) {
	//acho o maior saldo e pego a agência
	let copyArr = arr.slice();

	copyArr.sort((a, b) => b.balance - a.balance);
	document.getElementById('resposta4').innerHTML = copyArr[0].agencia;
}

function clienteMaiorSaldoAg(arr) {
	var maiores = [];
	let maior = 0;	

	for(var i = 0; i < arr.length; i++) {
		if(maior < arr[i].balance) maior = arr[i].balance;

		if(i == arr.length-1 || arr[i].agencia != arr[i+1].agencia) {
			
			maiores.push(maior);
			maior = 0;
		}
	}

	//somando 
	let sum = maiores.reduce(((prev, item) => prev + item), 0)
	

	document.getElementById('resposta5').innerHTML = sum;
	
}

function clienteMaiorSaldo(arr, ag) {
	let newArr = [];
	let maior = 0;

	newArr = arr.filter(el => el.agencia == ag);

	newArr.sort((a, b) => b.balance - a.balance);
	
	return newArr[0].name;
}

function clienteMenorSaldo(arr, ag) {
	let newArr = [];
	let maior = 0;

	newArr = arr.filter(el => el.agencia == ag);

	newArr.sort((a, b) => a.balance - b.balance);
	
	return newArr[0].name;
}

function clientesMenorSaldo(arr, ag) {
	let newArr = [];
	let names = [];

	newArr = arr.filter(el => el.agencia == ag);
	newArr.sort((a, b) => a.balance - b.balance);

	names.push(newArr[0].name, newArr[1].name, newArr[2].name)
	document.getElementById('resposta8').innerHTML = names.join(', ')
	
}

function getAgencia(arr, ag) {
	return arr.filter(el => el.agencia == ag);
} 

function contadorNome(arr, nome) {
	let cont = 0;

	for(let i = 0; i < arr.length; i++) {
		if(arr[i].name.split(' ').indexOf(nome) > -1) {
			cont++;
		} 
	}

	document.getElementById('resposta10').innerHTML = cont;
}

getData().then(response => {
	let data = response;
	console.log(data);
	//console.log(data[0].balance)

	//questão 1
	somaDeposito(data);
	//questão 2
	saldoMaior(data, 100);
	//questão 3
	saldoMaiorAgencia(data, 100, 33);
	//questão 4
	agMaiorSaldo(data);
	//questão 5
	clienteMaiorSaldoAg(data); //????
	//questão 6
	document.getElementById('resposta6').innerHTML = clienteMaiorSaldo(data, 10);
	//questão 7
	document.getElementById('resposta7').innerHTML = clienteMenorSaldo(data, 47);
	//questão 8
	clientesMenorSaldo(data, 47)
	//questão 9
	let data47 = getAgencia(data, 47);
	document.getElementById('resposta9').innerHTML = data47.length;
	//questão 10
	contadorNome(data47, 'Maria');


});




