// Get the video element
const videoElement = document.getElementById("camera");

// Access the user's webcam
navigator.mediaDevices.getUserMedia({ video: true })
.then((stream) => {
    // Set the video source to the live stream from the webcam
    videoElement.srcObject = stream;
})
.catch((error) => {
    console.log(error);
});

let listOfNewMembers = [];

//used to store the new members image as a string
let imageDataURL = null;


/**
 * Takes a picture and saves the image
 */
function take_snapshot() {
    //document.getElementById("demo").innerHTML = "TEST";

    // Get the video element from the HTML file
    const video = document.getElementById("camera");

    // Create a canvas element and set its dimensions to match the video element
    const canvas = document.createElement("canvas");
    canvas.width = video.videoWidth;
    canvas.height = video.videoHeight;

    // Draw the video frame onto the canvas
    const context = canvas.getContext("2d");
    context.drawImage(video, 0, 0, canvas.width, canvas.height);

    // Convert the canvas to a data URL
    const dataURL = canvas.toDataURL("image/jpeg");

    // // Create a link element and set its href and download attributes
    // const link = document.createElement("a");
    // link.href = dataURL;
    // link.download = "photo.jpg";

    // // Click the link to download the image file
    // link.click();

    imageDataURL = dataURL;
    document.getElementById("errorMessage").innerHTML = '';
}


/**
 * Submits a new member to the list of potential new members
 * @returns void
 */
function submitNewMember() {
    //make sure input if valid
    if (imageDataURL == null) {
        document.getElementById("errorMessage").innerHTML = "Please take your picture";
        return;
    }
    if (document.getElementById("firstName").value == '') {
        document.getElementById("errorMessage").innerHTML = "Please enter your first name";
        return;
    }
    if (document.getElementById("lastName").value == '') {
        document.getElementById("errorMessage").innerHTML = "Please enter your last name";
        return;
    }
    if (document.getElementById("age").value == '') {
        document.getElementById("errorMessage").innerHTML = "Please enter your age";
        return;
    }

    personClass = document.getElementById("class").value;
    if (personClass == '' || !(equalsIgnoringCase('freshman', personClass) || equalsIgnoringCase('sophomore', personClass) ||
    equalsIgnoringCase('junior', personClass) || equalsIgnoringCase('senior', personClass))) {

        document.getElementById("errorMessage").innerHTML = "Please enter either freshamn, sophomore, junior, or senior in the class text box";
        return;
    }

    //create person object
    let person = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        age: document.getElementById("age").value,
        class: document.getElementById("class").value,
        picture: imageDataURL
    };
    listOfNewMembers.push(person);

    //reset the values in the text boxes
    document.getElementById("firstName").value = '';
    document.getElementById("lastName").value = '';
    document.getElementById("age").value = '';
    document.getElementById("class").value = '';
    imageDataURL = null;
    document.getElementById("errorMessage").innerHTML = '';
}

/**
 * 
 * @param {string} text first string to compare
 * @param {string} other second string to compare
 * @returns true if the strings are the same ignoring case
 */
function equalsIgnoringCase(text, other) {
    return text.localeCompare(other, undefined, { sensitivity: 'base' }) === 0;
}

function printNewMemberArr() {
    document.getElementById("printArr").innerHTML = JSON.stringify(listOfNewMembers);
}



