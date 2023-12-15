function ysmooth = smoothing(x, ysalt, windowValue)

  ysmooth = 1:(size(ysalt, 2));

  for i = 1:size(ysalt, 2)

    smoothedValue = 0;
    windowTotal = 0;
    numberOfPoints = 0;

    if ((i - windowValue) < 1)
      for j = 1:i + windowValue
        windowTotal = windowTotal + ysalt(j);
        numberOfPoints = numberOfPoints + 1;
      endfor
    elseif((i + windowValue) > size(ysalt, 2))
      for j = (i - windowValue):(size(ysalt, 2))
        windowTotal = windowTotal + ysalt(j);
        numberOfPoints = numberOfPoints + 1;
      endfor
    else
      for j = (i - windowValue):(i + windowValue)
        windowTotal = windowTotal + ysalt(j);
        numberOfPoints = numberOfPoints + 1;
      endfor
    endif

    smoothedValue = windowTotal/numberOfPoints;
    ysmooth(i) = smoothedValue;

  endfor

  plot(x, ysmooth, "-ob", "MarkerSize", 2)
  title("2x^2 + 4x + 3 smoothed")
  set(gca, "fontsize", 18)

end
