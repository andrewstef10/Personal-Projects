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

    // Create a link element and set its href and download attributes
    const link = document.createElement("a");
    link.href = dataURL;
    link.download = "photo.jpg";

    // Click the link to download the image file
    link.click();

}
