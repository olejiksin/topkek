var inputArea = document.getElementById('input');
var calc = document.getElementById('calc');

var buttons = [
    '1', '2', '3', '+',
    '4', '5', '6', '-',
    '7', '8', '9', '/',
    '0', '=', '.', '*',
    '<=', 'C','(',')'];

buttons.forEach((button) => {
    var btn = document.createElement('div');
    btn.className = 'btn';
    btn.innerHTML = button;
    calc.appendChild(btn);
});

const onClickFunc = (e) => {
    if (e.target.innerHTML === 'C') {
        inputArea.value = '0';
    } else if (e.target.innerText === '<=') {
        if (inputArea.value.length > 1 && inputArea.value !== '0') {
            inputArea.value = inputArea.value.slice(0, inputArea.value.length - 1);
        }
    } else if (e.target.innerHTML === '=') {
        inputArea.value = eval(inputArea.value).toString();
    } else if (inputArea.value === '0') {
        inputArea.value = e.target.innerText;
    } else {
        inputArea.value += e.target.innerText;
    }
}

document.querySelectorAll('.btn').forEach((button) => {
    button.addEventListener('click', onClickFunc)
});

