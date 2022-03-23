#include <stdio.h>

int isPrime(unsigned int n);

int main() {
  unsigned int number;
  printf("Please enter a number to justify whether it is a prime number : ");
  scanf("%u", &number);
  if (isPrime(number)) {
    printf("It is a prime number.");
  }else {
    printf("It is not a prime number.");
  }

  return 0;
}

int isPrime(unsigned int n) {
  if (n == 2 || n == 3) return 1;

  if (n <= 1 || n % 2 == 0 || n % 3 == 0) return 0;

  for (unsigned int i = 5; i * i <= n; i += 6) {
    if (n % i == 0 || n % (i + 2) == 0) return 0;
  }

  return 1;
}
