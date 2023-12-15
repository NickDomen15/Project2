function A = plotting(x, y, numberOfPoints, interval)

  plot(x(1:interval:numberOfPoints), y(1:interval:numberOfPoints), "-ob", "MarkerSize", 2)
  title("2x^2 + 4x + 3")
  set(gca, "fontsize", 18)

end
