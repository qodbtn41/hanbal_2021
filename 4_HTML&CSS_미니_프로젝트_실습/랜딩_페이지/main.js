var target = document.querySelector("#dynamic");

// 한글자씩 테스트 출력 함수
function dynamic(randomArr) {
  console.log(randomArr);
  if (randomArr.length > 0) {
    target.textContent += randomArr.shift();
    setTimeout(function () {
      dynamic(randomArr);
    }, 80);
  } else {
    setTimeout(resetTyping, 3000);
  }
}

function randomString() {
  let stringArr = ["Learn to HTML", "Learn to CSS", "Learn to Javascript", "Learn to Python", "Learn to Ruby"];
  let selectString = stringArr[Math.floor(Math.random() * stringArr.length)];
  let selectStringArr = selectString.split("");
  return selectStringArr;
}

function resetTyping() {
  target.textContent = "";
  dynamic(randomString());
}

dynamic(randomString());

console.log(selectString);
console.log(selectStringArr);

function blink() {
  target.classList.toggle("active");
}

setInterval(blink, 500);
