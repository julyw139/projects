# converts between Farenheit and Celsius
while True:
    inp = input('\nIs the input in Farenheit or Celsius? F/C ')
    if inp == 'F':
        temp_raw = input('\nWhat\'s the temperatue? ')
        try:
            temp_f = int(temp_raw)
            temp_c = (temp_f-32) * (5/9)
            print('\nThe temperature in Celsius is: {:0.0f}'.format(temp_c))
        except:
            print('\nInvalid input, please try again.')
            continue
    elif inp == 'C':
        temp_raw = input('\nWhat\'s the temperatue? ')
        try:
            temp_c = int(temp_raw)
            temp_f = temp_c*(5/9) + 32
            print('\nThe temperature in Farenheit is: {:0.0f}'.format(temp_f))
        except:
            print('\nInvalid input, please try again.')
            continue
    else:
        print('\nInvalid input, please try again.')
        continue
    
    inp2 = input('\nWould you like to convert another temperature? Y/N ' )
    if inp2 == 'Y':
        continue
    else:
        break
