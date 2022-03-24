#include <stdio.h>
#include <stdlib.h>
#include <map>

using namespace std;

struct Pow {
  int value = 0;
};

int isPrime(unsigned long long n);

int main() {
  unsigned long long number;

  printf("Please enter a number to do factorization : ");
  scanf("%I64u", &number);

  unsigned long long print_number = number;

  map<unsigned long long, Pow> factor;

  /* Factorization */
  if(isPrime(number)) {
    printf("It is a prime number.\n");
    factor[number].value += 1;
  }else {
      printf("It is not a prime number.\n");
    if (number == 2 || number == 3) {
      factor[number].value += 1;
    }else {
      for (unsigned long long i = 5; i <= number;) {
        if (number % i == 0) {
          factor[i].value += 1;
          number /= i;
        }else if (number % (i + 2) == 0) {
          factor[i+2].value += 1;
          number /= (i + 2);
        }else {
          i += 6;
        }
      }

      while (number % 2 == 0) {
        factor[2].value += 1;
        number /= 2;
      }
      while (number % 3 == 0) {
        factor[3].value += 1;
        number /= 3;
      }
    }
  }

  /* Print */
  printf("Factors: ");
  int first = 1;
  for (auto it = factor.begin(); it != factor.end(); ++it) {
    if (it->second.value != 0) {
      if(first) {
        printf("%I64u^%I64u", it->first, it->second.value);
        first = 0;
      }else {
        printf("*%I64u^%I64u", it->first, it->second.value);
      }
    }
  }

  return 0;
}

int isPrime(unsigned long long n) {
  if (n == 2 || n == 3) return 1;

  if (n <= 1 || n % 2 == 0 || n % 3 == 0) return 0;

  for (unsigned long long i = 5; i * i <= n; i += 6) {
    if (n % i == 0 || n % (i + 2) == 0) return 0;
  }

  return 1;
}
