/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function createHelloWorld(...args) {
        return "Hello World";
    }
       
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */