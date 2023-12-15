function [x, y] = calculateFunction(lowerBound, upperBound)

  x = lowerBound:upperBound;
  y = 2.*x.^2 + 4.*x + 3;

end
