#include <iostream>
#include <vector>
#include <algorithm>


std::vector<int> processData(const std::vector<int> &rawData) {
    std::vector<int> result;
    std::copy_if(
        rawData.begin(),
        rawData.end(),
        std::back_inserter(result),
        [](int x) { return x % 2 == 1; }
    );
    std::transform(
        result.begin(),
        result.end(),
        result.begin(),
        [](int x) { return x + 2; }
    );
    return result;
}

void printProcessedData(const std::vector<int> &processedData) {
    std::cout << "Processed data:\n";
    for (auto &it : processedData) {
        std::cout << it << '\n';
    }
}

int main() {
    std::vector<int> data = {2, 3, 9, 1};
    printProcessedData(processData(data));
}
