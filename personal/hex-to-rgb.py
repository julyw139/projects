# raw_str = input("\nPlease enter the hex code: ")
num_raw = input("\nEnter a number in base 10: ")
num = int(num_raw)
# let's write a converting to base 3 first
def to_base3(num):
    if num < 3:
        digit = int(num)
        print(digit, end = '')
    else:
        digit = int(num/3)
        to_base3(digit)
        print(num % 3, end = '')
def hex_map(let):
    if let == 'a':
        return 10
    elif let == 'b':
    #ooo use dictionaries you really should finish that book first
def hex_to_dec(num)