function A = posneg(x)
  if(x > 0)
    fprintf("positive\n")
  elseif (x < 0)
    fprintf("negative\n")
  else
    fprintf("zero\n")
  endif
end
