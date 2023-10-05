function myFunction(input1, input2){
  // Return statement is optional
  return '';
}

/*
 * Can pass different kinds of values to the same function
 */ 
myFunction('some string', false);
myFunction(2.3, 1);


const requests = [
  'can you pass the salt',
  'can I borrow your car',
  'can you pickup some cheese'
];

/*
 * Sample callback function
 */
function politeRequest(request){
  const politeRequest = `${request}, please`;
  return politeRequest;
}

/*
 * map method using named function and anonymous method
 */
const politeRequestsArr = requests.map( politeRequest );
const politeRequestsArr2 = requests.map( (eachRequest) => {
  const politeRequest = `${eachRequest}, please`;
  return politeRequest;
});

/*
 * Original array doesn't change
 */
console.log(requests);

/*
 * Both arrays contain the same elements
 */
console.log(politeRequestsArr);
console.log(politeRequestsArr2);




/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3, and uses a anonymous function.
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
const arr = [1, 3, 9, 11, -2, 0, 12];
function multiplesThree(arr){
  const filteredArr = arr.filter( (eachNumber) => {
      return eachNumber % 3 === 0;
  });

  console.table(filteredArr);
  return filteredArr;
}

// Rest parameter, i.e. vargs. vargs stands for variable arguments
// vargs is an array representing all the arguments passed into the function
function restExample(...vargs){
  vargs.forEach( (eachArgument, index) => {
    console.log(`The index ${index} in vargs is: ${eachArgument}`);
  });
}

restExample(42);
restExample(1, 2, 3);
restExample('a', 'b', 'c', 'd');