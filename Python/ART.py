# -*- coding: UTF-8 -*-

import numpy as np

class ART:
  def __init__(self, n=5, m=10, L=1.5, rho=0.5):

    """

    ART1 NN with random weights

    Parameters
    -----------
    n : int
      dimension of input
    m : int
      numbers of nuerons of F2 layer (max number of categories)
    L : float
      learning parameter
    rho : float
      vigilance parameter

    Internal parameters
    -----------
    F1 : array, binary
      comparison layer - input
    F2 :
      recognition layer - output
    Wb : matrix, float
      match value - feed-back weights - output to input
    Wf : matrix, float
      match value - feed-forward weights - input to output
    active : int
      available identifier during learning
    beta : float
      learning parameter minus 1
    rho : float
      vigilance parameter

    """

    self.F1 = np.ones(n)

    self.F2 = np.ones(m)

    self.Wb = np.random.random((n,m))

    self.Wf = np.random.random((m,n))

    self.rho = float(rho)

    self.beta = L - 1

    self.active = 0

  def learn(self, X):

    self.F1 = X

    self.F2 = np.dot(self.Wf, X)

    identifier = np.argsort(self.F2[:self.active].ravel())[::-1]

    # Use vigilance parameter to evaluate
    for i in identifier:
      v = (self.Wb[:,i]*X).sum()/X.sum() # Likelihood value
      if v >= self.rho:
          self.Wb[:,i] *= X # New match value
          self.Wf[i,:] = self.Wb[:,i]/(self.beta+self.Wb[:,i].sum()) # New match value
          return self.Wb[:,i], i # Match old identifier

    if self.active < self.F2.size:
      i = self.active
      self.Wb[:,i] *= X # New match value
      self.Wf[i,:] = self.Wb[:,i]/(self.beta+self.Wb[:,i].sum()) # New match value
      self.active += 1 # New identifier
      return self.Wb[:,i], i

    return None,None

  def predict(self, X):

    identifier = np.argsort(self.F2[:self.active].ravel())[::-1]

    # Use vigilance parameter to evaluate
    for i in identifier:
      v = (self.Wb[:,i]*X).sum()/X.sum() # Likelihood value
      if v >= self.rho:
          return i # Match old identifier

    return None