// Dados
const kmPorDia = 11.6 * 2; // ida e volta
const diasPorSemana = 5; // segunda a sexta
const consumoKmPorLitroEtanol = 9.3; // consumo médio do carro em km/l no etanol
const consumoKmPorLitroGasolina = 12.35; // consumo médio do carro em km/l na gasolina
const precoEtanol = 3.97; // preço do etanol por litro
const precoGasolina = 6.19; // preço da gasolina por litro
const pedagioIda = 5.2; // custo do pedágio na ida
const semanasNoMes = 4; // média de semanas em um mês
const salarioBruto = 7659.0; // salário bruto
const percentualOnibus = 0.06; // desconto de 6% do salário para ir de ônibus

const custoMensalOnibus = salarioBruto * percentualOnibus;
const kmSemanal = kmPorDia * diasPorSemana;
const custoPedagioSemanal = pedagioIda * diasPorSemana;
const custoMensalPedagio = custoPedagioSemanal * semanasNoMes;

console.log(
  `Seu trajeto diário será de aproximadamente ${kmPorDia.toFixed(
    1
  )} KM, totalizando num trajeto semanal de aproximadamente ${kmSemanal.toFixed(
    1
  )}`
);

console.log(
  `O gasto com pedágio por semana será de R$ ${custoPedagioSemanal.toFixed(
    2
  )}, totalizando num gasto mensal de R$ ${custoMensalPedagio.toFixed(2)}.`
);

const etanolPorGasolina = precoEtanol / precoGasolina;

if (etanolPorGasolina < 0.7) {
  console.log("É mais vantajoso abastecer com Etanol.");

  const litrosSemanalEtanol = kmSemanal / consumoKmPorLitroEtanol;
  const custoEtanolSemanal = litrosSemanalEtanol * precoEtanol;

  console.log(
    `O consumo médio de Etanol por semana será aproximadamente de ${litrosSemanalEtanol.toFixed(
      1
    )} litros.`
  );

  const custoMensalCarroEtanol =
    (custoEtanolSemanal + custoPedagioSemanal) * semanasNoMes;

  const custoMensalSemPedagio = custoEtanolSemanal * semanasNoMes;
  console.log(
    `O custo mensal sem pedágio é de R$ ${custoMensalSemPedagio.toFixed(2)}`
  );

  // Resultado
  console.log(
    "Custo mensal com o carro rodando no Etanol: R$",
    custoMensalCarroEtanol.toFixed(2)
  );

  console.log("Custo mensal com ônibus: R$", custoMensalOnibus.toFixed(2));

  console.log(
    "Diferença de custo (carro - ônibus): R$",
    (custoMensalCarroEtanol - custoMensalOnibus).toFixed(2)
  );
} else {
  console.log("Abasteça com Gasolina.");

  const litrosSemanalGasolina = kmSemanal / consumoKmPorLitroGasolina;
  const custoGasolinaSemanal = litrosSemanalGasolina * precoGasolina;

  console.log(
    `O consumo médio de Gasolina por semana será aproximadamente de ${litrosSemanalGasolina.toFixed(
      1
    )} litros.`
  );

  const custoMensalCarroGasolina =
    (custoGasolinaSemanal + custoPedagioSemanal) * semanasNoMes;

  const custoMensalSemPedagio = custoGasolinaSemanal * semanasNoMes;

  console.log(
    `Custo mensal desconsiderando o pedágio: R$ ${custoMensalSemPedagio.toFixed(
      2
    )}`
  );
  console.log(
    "Custo mensal com o carro rodando na Gasolina: R$",
    custoMensalCarroGasolina.toFixed(2)
  );

  console.log("Custo mensal com ônibus: R$", custoMensalOnibus.toFixed(2));

  console.log(
    "Diferença de custo (carro - ônibus): R$",
    (custoMensalCarroGasolina - custoMensalOnibus).toFixed(2)
  );
}
