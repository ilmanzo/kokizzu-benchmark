res = [last=3]
loop do 
   last += 2
   prime = true
   res.each do |v|
   	  break if v*v > last 
   	  if last % v == 0 
        prime = false 
        break
      end
   end
   if prime
     res << last 
     puts last if res.length % 100000 == 0 
     break if last > 9999999
   end
end