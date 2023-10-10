
function filterCallbackFn(element){
  // return an expression that is true or false
  return element % 2 === 0;
}

// input:  [1, 1, 2, 3, 5, 8, 13]
// output: [2, 8]

// given an array of [1, 1, 2, 3, 5, 8, 13]
// Write a function to return an array of only even numbers
const arr = [1, 1, 2, 3, 5, 8, 13];
function filterEvens(arrToFilter){
  return arrToFilter.filter((element) => {
    // return an expression that is true or false
    return element % 2 === 0;
  });
}
console.log('filterEvents: ' + filterEvens(arr));


function gradesCallbackFn(element){
  //
  if(element < 60){
    return 'F';
  }
  else if(element < 70){
    return 'D';
  }
  else if(element < 80){
    return 'C';
  }
  else if(element < 90){
    return 'B';
  }
  else {
    return 'A';
  }
}

// input:  [100,  89,    92,  83,  72,  55, 80]
// output: ['A',  'B',  'A', 'B', 'C', 'F', 'B']

// given an array [100,  89,  92,  83,  72,  55, 80]
// Write a function to return an array of letter grades
const scores = [100,  89,  92,  83,  72,  55, 80];
function mapScoresToGrades(scores){
  return scores.map(gradesCallbackFn);
}
console.log('mapScoresToGrades: ' + mapScoresToGrades(scores));


// input:  [1, 1, 2, 3, 5, 8, 13]
// output: 23

// given an array of [1, 1, 2, 3, 5, 8, 13]
// Write a function to return the sum of odd numbers
function sumOdd(numArr){
  return numArr.reduce( (runningTotal, eachNum) => {
    
    // Check if number is odd
    if(eachNum % 2 !== 0){
      return runningTotal + eachNum;
    }

    // Number is not odd...
    return runningTotal;

  }, 0);
}
console.log('sumOdd: ' + sumOdd([1, 1, 2, 3, 5, 8, 13]));


// output: 150

// Write a function to get the total
// entertainment costs from an array of objects
// containing the type of cost and its amount
// 
// const weeklyCosts = [
//   { type: 'entertainment',  cost: 100 },
//   { type: 'internet',       cost: 70 },
//   { type: 'entertainment',  cost: 50 },
//   { type: 'transportation', cost: 125 },
// ]

const weeklyCosts = [
  { type: 'entertainment',  cost: 100 },
  { type: 'internet',       cost: 70 },
  { type: 'entertainment',  cost: 50 },
  { type: 'transportation', cost: 125 },
]

// Return an array of cost values for entertainment costs
// output: [100, 50]
function getEnterTainmentCostsArray(arrCosts){

  // METHOD 1: filter & callback
  // Array after filtering by type === 'entertainment'
  //  [
  //   {type: 'entertaintment, cost: 100},
  //   {type: 'entertaintment, cost: 50}
  //  ]
  // return arrCosts.filter( callbackFn ).map( callbackFn );
  //
  // return arrCosts.filter( (eachCostObj) => {
  //   return eachCostObj.type === 'entertainment';
  // })
  // .map( (eachEntertainmentObj) => {
  //   //return eachEntertainmentObj.cost;
  //   return eachEntertainmentObj['cost'];
  // });

  // METHOD 2: filter & callback shorthand
  // return arrCosts.filter( eachCostObj => eachCostObj.type === 'entertainment')
  //                .map( eachEntertainmentObj => eachEntertainmentObj['cost']);

  // METHOD 3: reduce to a single array object
  return arrCosts.reduce((entertainmentCostsArr, eachCostObj) => {
    if(eachCostObj.type === 'entertainment'){
      entertainmentCostsArr.push(eachCostObj.cost)
    } 
    return entertainmentCostsArr;
  }, []);
}
console.log('getEnterTainmentCostsArray: ' + getEnterTainmentCostsArray(weeklyCosts));

function calculateEntertainmentCosts(arrCosts){
  return arrCosts.reduce( (runningTotal, eachCostObj) => {

    // Cost type is entertainment
    if(eachCostObj.type === 'entertainment'){
      return eachCostObj.cost + runningTotal;
    }

    // Cost type is not entertainment....
    return runningTotal;

  }, 0);
}
console.log('calculateEntertainmentCosts: ' + calculateEntertainmentCosts(weeklyCosts));