// const path = require("path");
// const MiniCssExtractPlugin = require("mini-css-extract-plugin");

// module.exports = {
//   entry: "./src/index.js",
//   output: {
//     path: path.resolve(__dirname, "dist"),
//     filename: "bundle.js"
//   },
//   module: {
//     rules: [
//       {
//         test: /\.scss$/,
//         use: [
//           MiniCssExtractPlugin.loader,
//           "css-loader",
//           "sass-loader",
//           {
//             loader: "sass-loader",
//             options: {
//               prependData: '@import "./node_modules/bootstrap/scss/bootstrap";',
//             },
//           },
//         ]
//       },
//       {
//         test: /\.css$/,
//         use: [
//           MiniCssExtractPlugin.loader,
//           "css-loader",
//           {
//             loader: "css-loader",
//             options: {
//               prependData: '@import "./node_modules/bootstrap/dist/css/bootstrap.min.css";',
//             },
//           },
//         ]
//       },
//       {
//         test: /\.(png|jpeg|gif|svg)$/,
//         use: [
//           {
//             loader: "file-loader",
//             options: {
//               name: "[path][name].[ext]",
//             },
//           },
//         ],
//       },
//       {
//         test: /\.(woff|woff2|eot|ttf|otf)$/,
//         use: [
//           "file-loader"
//         ],
//       },
//     ],
//   },
//   plugins: [
//     new MiniCssExtractPlugin({
//       filename: "style.css"
//     }),
//   ],
// };
