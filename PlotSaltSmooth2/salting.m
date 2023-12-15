function ysalt = salting(x, y, saltValueRange)

  ysalt = 1:(size(y, 2));

  for i = 1:(size(y, 2))
    opperation = randi(2);
    if ((opperation = 1))
      ysalt(i) = y(i) + randi(saltValueRange);
    elseif ((opperation = 2))
      ysalt(i) = y(i) - randi(saltValueRange);
    endif
  endfor

  plot(x, ysalt, "-ob", "MarkerSize", 2)
  title("2x^2 + 4x + 3 salted")
  set(gca, "fontsize", 18)

end
